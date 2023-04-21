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
//Select Record from the table

$sql="SELECT * FROM `tp` WHERE `des`='India'";

//Do not create same name table in db.
$result=mysqli_query($conn,$sql);

// Find the total number of record in the table
 $num= mysqli_num_rows($result);
 echo $num. " Total No.of record found "."<br/>";

 $no=1;
 if ($num > 0) {
    while ($row = mysqli_fetch_assoc($result)) {
        // echo var_dump($row)."<br/>";
      //  echo $row["sno"] . ". Hello " . $row["name"] . " Welcome " . $row["des"] . "<br/>";
       
      //update the serial number:
        echo $no . ". Hello " . $row["name"] . " Welcome " . $row["des"] . "<br/>";
        $no+=1;
    }
}
// Usage of WHERE Clause to Update Data
$sql="UPDATE `tp` SET `name` ='FromBan' WHERE `des`='Ban'";
$result=mysqli_query($conn,$sql);
echo var_dump($result);
$aff=mysqli_affected_rows($conn);
echo "<br/>Number of affected rows: $aff <br/>";
if($result){
    echo "We Update the record Successfully";
}else{
    echo "We could not update the record successfully";
}

?>