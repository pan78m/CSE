<?php 
//Create Databases using sql command

$servername="localhost";
$username="root";
$password="";
$dbn="Pan";

//connection to database
$conn=mysqli_connect($servername,$username,$password,$dbn);
if(!$conn){
    die("Could not connect mysql->".mysqli_connect_error());
}else{
 echo "Connected Successfully to Database<br/>";   
}
//Insert Record in the table
$name="";
$des="";
$sql="INSERT INTO `tp` (`sno`, `name`, `des`) VALUES (NULL, 'Srity Rani', 'Ban')";

//Do not create same name table in db.
$result=mysqli_query($conn,$sql);
if($result){
    echo "Record Insert Successfull<br/>";   
   }else{
       echo "Record Insert Failed---->".mysqli_error($conn);
   }
   mysqli_close($conn);

   ?>