<?php

// magic constant
// LINE constant return value which line i stay of the code?

echo "You are at line number " . __LINE__ . "<br><br>";  

// file constant which file exist this code
//return file value is path of the file location

echo __FILE__ . "<br><br>";  


  //print full path of directory where script will be placed    
  echo __DIR__ . "<br><br>";  
  //below output will equivalent to above one.  
  echo dirname(__FILE__) . "<br><br>";    

?>