<template>
    <input type="text" v-model="username" placeholder="用户名:" />
    <br />
    <input type="text" v-model="pwd" placeholder="密码:" />
    <br />
    <input type="text" v-model="pwd2" placeholder="密码确认:" />
    <br />
    <button @click="submit()">注册</button>
    <br />
    <button @click="clear()">清空</button>
  </template>
  <script>
  import axios from "axios";
  export default {
    name: "Register",
  
    data() {
      return {
        username: "",
        pwd: "",
        pwd2: "",
      };
    },
    methods: {
      clear() {
        this.username = "";
        this.pwd = "";
        this.pwd2 = "";
      },
      submit() {
        if (this.pwd != this.pwd2) {
          alert("两次输入的密码必须一致！");
          return;
        }
        var returnData = {
          username: this.username,
          PWD: this.pwd,
        };
        axios.defaults.headers.post["Content-Type"] = "application/json";
        axios
          .post("http://121.36.65.13:8090/register", JSON.stringify(returnData))
          .then((res) => {
            console.log(res.data);
            if (1 == res.data.code) {
              alert(res.data.info);
              this.$router.push("/");
            } else {
              alert(res.data.info);
            }
          });
      },
    },
  };
  </script>
  
  <style scoped></style>