<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <textarea type="textarea" v-model="question" readonly>题目：</textarea>
    <br />
    <input type="text" v-model="answer" placeholder="答案:" />
    <br />
    <button @click="check()">提交</button>
    <button @click="refresh()">刷新</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      question: "",
      op1: "",
      op2: "",
      //     result: "",
    };
  },
  mounted() {
    //alert("hoho");
    let qid = this.$route.query.qid;
    //alert(qid);
    axios.get("http://121.36.65.13:8090/start?qid=" + qid).then(
      // 成功回调
      (success) => {
        console.log("请求成功！");
        // 请求成功后的数据
        console.log(success.data);
        this.question = success.data.str;
        this.op1 = success.data.op1;
        this.op2 = success.data.op2;
        //       this.result = success.data.result;
      },
      // 失败回调
      (error) => {
        console.log("请求失败！");
        // 请求失败原因
        console.log(error.message);
      }
    );
  },
  methods: {
    refresh() {
      location.reload();
    },
    check() {
      //   if (this.result == this.answer) alert("正确！");
      //   else alert("错误!");

      var returnData = {
        op1: this.op1,
        op2: this.op2,
        result: this.answer,
        qid: this.$route.query.qid,
      };

      axios.defaults.headers.post["Content-Type"] = "application/json";
      axios
        .post("http://121.36.65.13:8090/check", JSON.stringify(returnData))
        .then((res) => {
          console.log(res.data);

          alert(res.data.str);
        });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
