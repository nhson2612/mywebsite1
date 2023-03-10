<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  <style>
    .red {
      color: red;
    }
    .buttonSubmit{
      display: grid;
      place-content: center;
    }
  </style>
</head>
<body>
<%
    String name = "";
    if ((request.getAttribute("name") != null)) {
      request.getAttribute("name").toString();
    }
    String numberPhone = "";
    if ((request.getAttribute("numberPhone") != null)) {
      numberPhone = request.getAttribute("numberPhone").toString();
    }
    String dateOfBirth = "";
    if ((request.getAttribute("dateOfBirth") != null)) {
      dateOfBirth = request.getAttribute("dateOfBirth").toString();
    }
    String address = "";
    if ((request.getAttribute("address") != null)) {
      address = request.getAttribute("address").toString();
    }
    String email = "";
    if ((request.getAttribute("email") != null)) {
      email = request.getAttribute("email").toString();
    }
%>
<form action="do-Register" method="post">
  <div class="container px-4 text-center">
    <div class="row gx-5">
      <div class="col">
        <div class="p-3">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputName" placeholder="Nguyen Van A" name="name" value="<%=name%>">
            <label for="floatingInputName">T??n<span class="red">*</span></label>
          </div>
          <div class="form-floating mb-3">
            <input type="number" class="form-control" id="floatingInputNumberPhone" placeholder="S??? di???n tho???i" name="numberPhone" value="<%=numberPhone%>">
            <label for="floatingInputNumberPhone">S??? di???n tho???i<span class="red">*</span></label>
          </div>
          <div class="form-floating mb-3">
            <input type="date" class="form-control" id="floatingInputDateOfBirth" placeholder="mm/dd/yy" name="dateOfBirth" value="<%=dateOfBirth%>">
            <label for="floatingInputDateOfBirth">Ng??y sinh<span class="red">*</span></label>
          </div>
          <div class="form-floating mb-3">
            <label for="gioiTinh" class="form-control">Gi???i t??nh</label>
            <select name="sex" id="gioiTinh" class="form-control">
              <option value="male">Nam</option>
              <option value="female">N???</option>
            </select>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputAddress" placeholder="?????a ch???" name="address" value="<%=address%>">
            <label for="floatingInputAddress">?????a ch???</label>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="p-3">
          <div class="form-floating mb-3">
            <input type="email" class="form-control" id="floatingInputEmail" placeholder="name@example.com" name="email" value="<%=email%>">
            <label for="floatingInputEmail">Email address<span class="red">*</span></label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInputUserName" placeholder="T??n ????ng nh???p" name="userName">
            <label for="floatingInputUserName">T??n ????ng nh???p<span class="red">*</span></label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control" id="floatingInputPassword" placeholder="Password" name="passWord" onkeyup="confirmPassWord()">
            <label for="floatingInputPassword">Password<span class="red" >*</span></label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control" id="floatingInputConfirmPassword" placeholder="Confirm Password" name="confirmPassWord" onkeyup="confirmPassWord()">
            <label for="floatingInputConfirmPassword">Confirm Password<span class="red" id="spanConfirmPassWord">*</span></label>
          </div>
          <div class="buttonSubmit">
            <button type="submit" class="btn btn-primary">????ng k??</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <label id="error" name="true"></label>
</form>
<script>
  error = document.getElementById("error");
  if(error=="x??c nh???n m???t kh???u kh??ng kh???p"){
    window.alert("x??c nh???n m???t kh???u kh??ng kh???p , Vui l??ng nh???p l???i");
  }else if(error=="username ???? t???n t???i"){
    window.alert("T??n ng?????i d??ng ???? t???n t???i");
  }else if(error=="email ???? ???????c ????ng k??"){
    window.alert("Email ???? ???????c ????ng k??");
  }
</script>
</body>
</html>
