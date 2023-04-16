<?php

//PHP has three types of variable scopes:

// Local variable
// Global variable
// Static variable


// work at local variable

function local_var()
{
   $num=10;
   echo "Local variable";
      for($i=0;$i<$num;$i++){
    if($i%2==0){
       echo "<br/>value is:" . $i ; 
    }
   }
}
// find this error message because of variable scopes num is local variable
  //echo $num;
 local_var();


 // work at global variable
  $name="Devosho Arya";
 function global_var(){
    echo "<br/>Global variable";
     global $name;
    echo "<br/>This is inside the function-> ".$name;
 }
      global_var();
   echo "<br/>This is the outside of the function-> ".$name;
// static variable
 function static_var(){
    static $n1=10;
    $n2=5;
    echo "<br/>Static variable";
    // increment local variable number
    $n2++;
    // increment static variable number
    $n1++;
    echo"<br/>Local value->".$n2;
    echo "<br/>Static value->".$n1;
 }
 // first time call
  static_var();
  //Second time call
  static_var();
  
 ?>