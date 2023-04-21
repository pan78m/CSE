<?php 
//Create Databases using sql command

$servername="localhost";
$username="root";
$password="";
$dbn="";
echo "Today's I making database using php command<br/>";
$conn=mysqli_connect($servername,$username,$password);
// if(!$conn){
//     die("Could not connect mysql->".mysqli_connect_error());
// }else{
//  echo "Connected Successfully to Database<br/>";   
// }
//create databases
$sql="CREATE DATABASE Pan1";
$result=mysqli_query($conn,$sql);


if($result){
    echo "Database Create Successfull<br/>";   
   }else{
       echo "Database created Failed---->".mysqli_error($conn);
   }
   mysqli_close($conn);  


?>