<?php 
    include "conexao.php";

    $id = $_POST['id'];

    $sql_delete = "DELETE FROM tbl_usuario WHERE id=:ID";

    $stmt = $pdo->prepare($sql_delete);

    $stmt->bindParam(':ID', $id);   

    if($stmt->execute()) {

        $dados = array("DELETE"=>"OK");
    } else {
        $dados = array("DELETE"=>"ERRO");
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