<template>
    <input type="text" v-model="username" placeholder="用户名:" />
    <br />
    <input type="text" v-model="pwd" placeholder="密码:" />
    <br />
    <button @click="login()">登录账号</button>
    <br />
    <a href="/register">注册账号</a>
  </template>
  
  <script>
  import axios from "axios";
  export default {
    name: "Login",
  
    data() {
      return {
        username: "",
        pwd: "",
      };
    },
    methods: {
      login() {
        //   if (this.result == this.answer) alert("正确！");
        //   else alert("错误!");
  
        var returnData = {
          username: this.username,
          PWD: this.pwd,
        };
  
        axios.defaults.headers.post["Content-Type"] = "application/json";
        axios
          .post("http://121.36.65.13:8090/login", JSON.stringify(returnData))
          .then((res) => {
            console.log(res.data);
            if (1 == res.data.code) {
              alert("登录成功");
              this.$router.push("/index");
            } else {
              alert(res.data.info);
            }
          });
      },
    },
  };
  </script>
  <style scoped></style>