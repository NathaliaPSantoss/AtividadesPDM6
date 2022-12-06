<?php 
    include "conexao.php";

    $id = $_POST['id'];
    $nome = $_POST['nome'];
    $tel = $_POST['cel'];
    $email = $_POST['email'];

    $sql_update = "UPDATE tbl_usuario SET 
    nome=:NOME,
    telefone=:TEL,
    email=:EMAIL 
    WHERE id=:ID";

    $stmt = $pdo->prepare($sql_update);

    $stmt->bindParam(':ID', $id);
    $stmt->bindParam(':NOME', $nome);
    $stmt->bindParam(':TEL', $tel);
    $stmt->bindParam(':EMAIL', $email);

    if($stmt->execute()) {
        //$id= $pdo->lastInsertId();
        $dados = array("UPDATE"=>"OK", "ID"=>$id);
    } else {
        $dados = array("UPDATE"=>"ERRO");
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