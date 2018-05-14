package main.scala

 import org.apache.spark.SparkConf
    import org.apache.spark.SparkContext
    object ScalaWordCount {
        def main(args: Array[String]) {
            //To set HADOOP_HOME.
            System.setProperty("hadoop.home.dir", "c://hadoop//");
            // create Spark context with Spark configuration
            val sc = new SparkContext(new SparkConf().setAppName("Spark WordCount").setMaster("local[2]"))
                    //Load inputFile
                    val inputFile = sc.textFile("src/input.txt")
                    val counts = inputFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
                    counts.foreach(println)
                    sc.stop()
        }
    }