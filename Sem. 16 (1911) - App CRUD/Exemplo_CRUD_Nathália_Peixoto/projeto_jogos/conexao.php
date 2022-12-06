<?php
    $dsn = "mysql:host=localhost;dbname=bd_jogos;charset=utf8";
    $usuario = "root";
    $senha = "";

    try {
        $pdo = new PDO($dsn,$usuario,$senha);
        //echo "<h1>Deu bom! ;)</h1>";
    } catch (PDOException $erro) {
        //echo "<h1>Deu RUIM! ;(</h1>";
        //echo "<h1>".$erro->getMessage()."</h1>";
    }
    
?>