
import java.io._
import scala.io.Source
import scala.math.random
import org.apache.spark._

object testingsort extends App{
  override def  main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Sort").setMaster("local")
    val sc = new SparkContext(conf)
    
    var myOne = List(List("cat", "mat","bat"), List("hat","mat","rat"), List("cat","mat","sat"),List("cat","fat","bat"))
    myOne.foreach(println)
    var myTwo = sc.parallelize(myOne)
    myTwo.foreach(println)
    var myThree = myTwo.map(x => (x(1), x(2)))
    myThree.foreach(println)
    var myFour = myThree.sortBy(_._1, false).sortBy(_._2)
    myFour.foreach(println)
    
    val writer = new PrintWriter(new File("test.txt" ))
    

    writer.write("Hello World")
    
    var tf = sc.textFile("dataFile")
    var counts = tf.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
    counts.foreach(println)
    
    val res = counts.collect()
    for (n <- res) writer.println(n.toString())
      
    writer.close()
  
  
    
    
    
  }
}