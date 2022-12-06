<?php

include "conexao.php";

    $sql_read = "SELECT * FROM tbl_usuario";
    $dados = $pdo->query($sql_read);
    

    $resposta = array();

    while ($j = $dados->fetch(PDO::FETCH_OBJ)) {
        $resposta[] = array(
        "id"=>$j->id,
        "nome"=>$j->nome,
        "cel"=>$j->telefone,
        "email"=>$j->email);
        
    }

    //echo "<pre>" .json_encode($resposta, JSON_PRETTY_PRINT) . "</pre>";
    echo json_encode($resposta);

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Read</title>
    <style>
        body {
			text-align: center;
		}
    </style>
</head>
<body>
    </br></br><a href="index.html"><button type="submit">Voltar</button></a>
</body>
</html>