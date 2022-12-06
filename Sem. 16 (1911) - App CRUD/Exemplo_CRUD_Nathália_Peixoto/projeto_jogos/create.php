<?php 
    include "conexao.php";

    $nome = $_POST['nome'];
    $tel = $_POST['cel'];
    $email = $_POST['email'];

    $sql_insert = "INSERT INTO tbl_usuario (nome,telefone,email)
    VALUES(:NOME,:TEL,:EMAIL)";

    $stmt = $pdo->prepare($sql_insert);

    $stmt->bindParam(':NOME', $nome);
    $stmt->bindParam(':TEL', $tel);
    $stmt->bindParam(':EMAIL', $email);

    if($stmt->execute()) {
        $id= $pdo->lastInsertId();
        $dados = array("CREATE"=>"OK", "ID"=>$id);
    } else {
        $dados = array("CREATE"=>"ERRO");
    }
    echo json_encode($dados);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create</title>
</head>
<body>
    </br></br><a href="index.html"><button type="submit">Voltar</button></a>
</body>
</html>