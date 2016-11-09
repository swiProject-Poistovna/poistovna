
 
   <!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sk" lang="sk">
<head>
  <meta http-equiv="Content-Type"
content="application/xhtml+xml; charset=utf-8"/>
      <meta http-equiv="Content-Language"
content="sk"/>
<meta name="description" content="admin"/>
    <meta name="keywords"
content="studium,informatika"/>
<meta name="author" content="D.A"/>
<title>Sprava poistovni</title>
  </head>
  <body>
  <h1 style="text-align:center;font-size:300%">Správa záznamov</h1>
    <form action="#" method="post">
     <h3 style="text-align:center;font-size:200%;color:blue">Pridaj poisťovňu</h3>
       <h3 style="text-align:center;font-size:150%">Zadaj názov poisťovne : <input type="text" name="n" />  &nbsp;&nbsp;&nbsp; <input type="submit" name="nazov" value="Pridať" /></h3>
    </form>
          
       <form action="#" method="post">
     <h3 style="text-align:center;font-size:200%;color:blue">Pridaj typ produktu</h3>
       <h3 style="text-align:center;font-size:150%">Zadaj typ produktu : <input type="text" name="t" /> &nbsp;&nbsp;&nbsp; <input type="submit" name="typ" value="Pridať" /></h3>
    </form>
          <br/>   
     <form action="#" method="post">
   
   <p style="text-align:center"><input type="submit" name="poistovne" value="Zobraziť zoznam poisťovní" /> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
     <input type="submit" name="typyProduktov" value="Zobraziť typy produktov" />   </p>
    </form>
   
         <br/>
   <?php
   $login="sql7141780";
       $password="FlVTuBE81x";
       $server="sql7.freesqldatabase.com";
       $db="sql7141780";
       $spojenie=@mysqli_connect($server,$login,$password,$db);
       if(!$spojenie){
       die("Spojenie zlyhalo :" . mysqli_connect_error());
       }
        
         if(isset($_POST['poistovne'])){
          
        $dopyt="SELECT * FROM Poistovna";
       mysqli_query($spojenie,$dopyt);
       
       
       $vysledok=mysqli_query($spojenie,$dopyt);
       if(mysqli_num_rows($vysledok)>0){
             while($riadok=mysqli_fetch_row ($vysledok)){
             ?>
            <div style="text-align:center;font-size:120%"> <?php echo $riadok[1] . "<br/>"; ?> </div>   <?php
             }
       }
       
      }  
        if(isset($_POST['typyProduktov'])){
          
        $dopyt="SELECT * FROM TypProduktu";
       mysqli_query($spojenie,$dopyt);
       
       
       $vysledok=mysqli_query($spojenie,$dopyt);
       if(mysqli_num_rows($vysledok)>0){
             while($riadok=mysqli_fetch_row ($vysledok)){
             ?>
             <div style="text-align:center;font-size:120%"> <?php echo $riadok[1] . "<br/>"; ?> </div>   <?php
             }
       }
       
      }  
       if(isset($_POST['n'])){
         $n=mysqli_real_escape_string($spojenie,$_POST['n']);
         $n=htmlentities($n);
         if($n!=""){
         $dopyt="INSERT INTO Poistovna (nazov) VALUES ('$n')";
          if(mysqli_query($spojenie,$dopyt)){
          echo "Poisťovňa bola pridaná do databázy";
          } else{
          echo "Chyba pri pridávaní do databázy" . mysqli_error($spojenie);
          }
           }
          
       
        }  
         if(isset($_POST['t'])){
         $t=mysqli_real_escape_string($spojenie,$_POST['t']);
         $t=htmlentities($t);
         if($t!=""){
         $dopyt="INSERT INTO TypProduktu (nazov) VALUES ('$t')";
          if(mysqli_query($spojenie,$dopyt)){
          echo "Typ produktu bol pridaný do databázy";
          } else{
          echo "Chyba pri pridávaní do databázy" . mysqli_error($spojenie);
          }
          
          }
       
        }      
        mysqli_close($spojenie);
?>
 </body>
 </html>