//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.zip.GZIPInputStream;
//
//import opennlp.tools.ml.maxent.GISModel;
//import opennlp.tools.ml.maxent.GISTrainer;
//import opennlp.tools.ml.maxent.io.GISModelReader;
//import opennlp.tools.ml.maxent.io.GISModelWriter;
//import opennlp.tools.ml.maxent.io.BinaryGISModelWriter;
//import opennlp.tools.ml.model.AbstractModel;
//import opennlp.tools.ml.model.AbstractModelWriter;
//import opennlp.tools.ml.model.DataIndexer;
//import opennlp.tools.ml.model.DataReader;
//import opennlp.tools.ml.model.FileEventStream;
//import opennlp.tools.ml.model.MaxentModel;
//import opennlp.tools.ml.model.OnePassDataIndexer;
//import opennlp.tools.ml.model.PlainTextFileDataReader;
//
//public class maxEntTrain {
//    public static void main(String[] args) throws IOException {
//        //训练maxEnt模型
//        String trainingFileName = "E:\\依存分析训练数据\\train.txt";
//        String modelFileName = "E:\\依存分析训练数据\\train.txt.bin";
//        DataIndexer indexer = new OnePassDataIndexer();
//        indexer.index(new FileEventStream(trainingFileName));
////        MaxentModel trainedMaxentModel = new GISTrainer().trainModel(100,indexer);
//        //将训练好的模型存储到文件中供以后使用
////        File outFile = new File(modelFileName);
//
//    }
//}


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import opennlp.tools.ml.maxent.GIS;
import opennlp.tools.ml.maxent.io.GISModelReader;
import opennlp.tools.ml.maxent.io.SuffixSensitiveGISModelWriter;
import opennlp.tools.ml.model.AbstractModel;
import opennlp.tools.ml.model.AbstractModelWriter;
import opennlp.tools.ml.model.DataIndexer;
import opennlp.tools.ml.model.DataReader;
import opennlp.tools.ml.model.FileEventStream;
import opennlp.tools.ml.model.MaxentModel;
import opennlp.tools.ml.model.OnePassDataIndexer;
import opennlp.tools.ml.model.PlainTextFileDataReader;
import opennlp.tools.ml.model.BinaryFileDataReader;
import java.io.IOException;


public class maxEntTrain {
    public static void main(String[] args) throws IOException {
        //训练maxEnt模型
        String trainingFileName = "E:/test-koa/src/middleware/data/model/MaxEntModel.txt";
        String modelFileName = "E:/test-koa/src/middleware/data/model/MaxEnt_train.txt";
//        String trainingFileName = "E:\\test\\corpus\\dependency\\model\\MaxEntModel.txt";
//        String modelFileName = "E:\\test\\corpus\\dependency\\model\\MaxEnt_train.txt";

        DataIndexer indexer = new OnePassDataIndexer(new FileEventStream(trainingFileName));
        MaxentModel trainedMaxentModel = GIS.trainModel(100,indexer); // 100次迭代

        //将训练好的模型存储到文件中供以后使用
        File outFile = new File(modelFileName);
        AbstractModelWriter writer = new SuffixSensitiveGISModelWriter((AbstractModel) trainedMaxentModel, outFile);
        writer.persist();

        //从文件加载训练好的模型
        FileInputStream inputStream = new FileInputStream(modelFileName);
//        InputStream decodedInputStream = new GZIPInputStream(inputStream);

//      BinaryFileDataReader modelReader = new BinaryFileDataReader(inputStream);//读取二进制
////        DataReader modelReader = new PlainTextFileDataReader(inputStream);
//        MaxentModel loadedMaxentModel = new GISModelReader(modelReader).getModel();
//
//        //现在使用加载的模型预测结果
//        String[] context = {"等i-2", "udengi-2", "经济i-1", "ni-1", "犯罪i0", "vni0", "##空白##i1" ,"nulli1" ,"##空白##i2", "nulli2" ,"##核心##j-2", "rootj-2" ,"坚决j-1" ,"adj-1" ,"惩治j0", "vj0", "贪污j1" ,"vj1", "贿赂j2" ,"nj2", "犯罪→惩治" ,"vn→v" ,"犯罪→惩治5" ,"vn→v5", "经济@犯罪→惩治" ,"犯罪→坚决@惩治", "n@vn→v", "vn→ad@v"};
//        double[] outcomeProbs = loadedMaxentModel.eval(context);
//        String outcome = loadedMaxentModel.getBestOutcome(outcomeProbs);
//        System.out.println(outcome);
    }
}