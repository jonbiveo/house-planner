<template>
  <div class="main-contact">
    <div class="contact-header">
      <h2>Questions?</h2>
      <h3>Please Fill Out the Form Below</h3>
    </div>

    <form class="contact-form-box">
      <div class="contact-form">
        <div class="name-input">
          <label for="full-name" value="fullName">Full Name</label>
          <input name="full-name" type="text" />
        </div>
        <div class="email-input">
          <label for="email" value="email">Email Address</label>
          <input name="email" type="text" />
        </div>
        <div class="message-input">
          <label for="message" value="message">Message</label>
          <textarea name="email" type="textarea"></textarea>
        </div>
      </div>
      <div class="submit-input">
        <span class="btn-submit">
          <img src="../assets/button-submit.svg" /> Submit
        </span>
      </div>
    </form>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-contact {
  padding: 1% 30%;
  height: 85.2vh;
  background-color: #ffe9b3;
}
h3 {
  margin: 0 0 20px 0;
}

.contact-header {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.contact-form-box {
  background-color: #e76f51;
  border-radius: 10px;
  box-shadow: 5px 5px 5px #cc9b62;
  height: 50%;
  color: white;
}

.contact-form {
  display: grid;
  grid-template-rows: repeat(4, 25%);
  background-color: #e76f51;
  border-radius: 10px;
  height: 50%;
  padding: 5% 20%;
}

.name-input,
.email-input,
.message-input {
  display: flex;
  flex-direction: column;
  max-width: 400px;
}

input:focus, textarea:focus {
  height: 23px;
  border: 1px solid #315c6d;
  box-shadow: 0 0 10px #315c6d;
  outline: none;
}


.submit-input {
    display: flex;
    padding-left: 30px;
    max-width: 100px;
    margin-left: 300px;
    cursor: pointer;
    max-height: 30px;
  color: #264653;
  background-color: #e9c46a;
}
.name-input {
  grid-row-start: 1;
}
.email-input {
  grid-row-start: 2;
}
.message-input {
  grid-row-start: 3;
}

textarea {
  width: 100%;
  min-height: 100px;
}

.submit-input {
  grid-row-start: 4;
  display: flex;
  width: 150px;
}

.btn-submit {
  align-items: center;
  border: none;
  width: 100%;
  max-height: 30px;
  padding: 0 0 10px 0;
}

.btn-submit > img {
  max-height: 100%;
}
</style>