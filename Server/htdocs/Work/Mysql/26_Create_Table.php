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
//create a table in the DB
$sql="CREATE TABLE `tp` (`sno` INT(6) NOT NULL AUTO_INCREMENT, `name` VARCHAR(11) NOT NULL , `des` VARCHAR(11) NOT NULL , PRIMARY KEY (`sno`))";

//Do not create same name table in db.
$result=mysqli_query($conn,$sql);
if($result){
    echo "Table Create Successfull<br/>";   
   }else{
       echo "Table created Failed---->".mysqli_error($conn);
   }

   mysqli_close($conn);  


?>