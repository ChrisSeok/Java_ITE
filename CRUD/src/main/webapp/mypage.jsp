<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>����������</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* �߰����� ��Ÿ�ϸ��� ���⿡ �ۼ��ϼ��� */
        .profile-icon {
            font-size: 5rem;
            color: #6c757d; /* ȸ�� */
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="text-center">
        <i class="fas fa-user-circle profile-icon"></i> <!-- ȸ���� ū ���׶� �ι� ������ -->
        <h2 class="mt-3">����������</h2>
        <p>���̵�: <%= userId %></p> <!-- ������ ���̵� -->
        <p>�̸�: <%= userName %></p> <!-- ������ �̸� -->

        <!-- ȸ�� Ż��� ȸ�� ���� ���� ��ư -->
        <a href="deleteAccount.jsp" class="btn btn-danger mr-2">ȸ�� Ż��</a>
        <a href="editProfile.jsp" class="btn btn-primary">ȸ�� ���� ����</a>
        <a href="#" class="btn btn-primary">���� �� ��</a>
    </div>
</div>

<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
