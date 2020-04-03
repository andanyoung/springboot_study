package com.itcodai.course17.lucence;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 中文分词查询
 * @author shengwu ni
 */
public class ChineseSearch {

    private static final Logger logger = LoggerFactory.getLogger(ChineseSearch.class);

    public static List<String> search(String indexDir, String q) throws Exception {

        //获取要查询的路径，也就是索引所在的位置
        Directory dir = FSDirectory.open(Paths.get(indexDir));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        //使用中文分词器
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        //查询解析器
        QueryParser parser = new QueryParser("desc", analyzer);
        //通过解析要查询的String，获取查询对象
        Query query = parser.parse(q);

        //记录索引开始时间
        long startTime = System.currentTimeMillis();
        //开始查询，查询前10条数据，将记录保存在docs中
        TopDocs docs = searcher.search(query, 10);
        //记录索引结束时间
        long endTime = System.currentTimeMillis();
        logger.info("匹配{}共耗时{}毫秒", q, (endTime - startTime));
        logger.info("查询到{}条记录", docs.totalHits);

        //如果不指定参数的话，默认是加粗，即<b><b/>
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color=red>","</font></b>");
        //根据查询对象计算得分，会初始化一个查询结果最高的得分
        QueryScorer scorer = new QueryScorer(query);
        //根据这个得分计算出一个片段
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        //将这个片段中的关键字用上面初始化好的高亮格式高亮
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        //设置一下要显示的片段
        highlighter.setTextFragmenter(fragmenter);

        //取出每条查询结果
        List<String> list = new ArrayList<>();
        for(ScoreDoc scoreDoc : docs.scoreDocs) {
            //scoreDoc.doc相当于docID,根据这个docID来获取文档
            Document doc = searcher.doc(scoreDoc.doc);
            logger.info("city:{}", doc.get("city"));
            logger.info("desc:{}", doc.get("desc"));
            String desc = doc.get("desc");

            //显示高亮
            if(desc != null) {
                TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(desc));
                String summary = highlighter.getBestFragment(tokenStream, desc);
                logger.info("高亮后的desc:{}", summary);
                list.add(summary);
            }
        }
        reader.close();
        return list;
    }

    public static void main(String[] args) {
        String indexDir = "D:\\lucene2";
        //查询这个字符
        String q = "南京文明";
        try {
            search(indexDir, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
