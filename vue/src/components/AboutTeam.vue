<template>
  <div class="about-page">
    <div class="team-members">
      <div class="about-header"><h2>Meet the Devs</h2></div>
      <div class="member one">
        <img
          src="https://media-exp1.licdn.com/dms/image/C4D03AQGytTxPiWi3gA/profile-displayphoto-shrink_800_800/0/1626716458199?e=1638403200&v=beta&t=GAz9Eq-eMnG1LBc9JdsWAFptBFeudfWFwzZ7SAo_q8M"
        />
        <div class="text">
          <span class="full-name"
            >Logan <span class="last-name">Edmonds</span>
          </span>
          <p class="member-about">
            Ever since I could walk, I've been sitting at a computer, learning
            how they work. I've had the opportunity to build my own computers
            and tinker with their inner workings. This upbringing has given me a
            detail oriented and analytical mind to use towards software
            development. Attending Tech Elevator has allowed me to expand upon
            my passion and grow my knowledge of technology.
          </p>
        </div>
      </div>
      <div class="member two">
        <img
          src="https://media-exp1.licdn.com/dms/image/C4E03AQFuZMrcAg2TQQ/profile-displayphoto-shrink_800_800/0/1627061766392?e=1638403200&v=beta&t=2ievEyT_tc8N8u-XP5fuDPH2r6-xuMKUiZomYSUhMsM"
        />
        <div class="text flipped">
          <span class="full-name"
            >Molly <span class="last-name">Akers</span></span
          >
          <p class="member-about">
            For as long as I can remember, I have always loved the challenge of
            solving a puzzle. Even as a kid, I would ask my mom for
            problem-solving workbooks to do for fun. Working as a nurse, I honed
            my time management and critical thinking skills. During COVID, I
            started to learn to code during my free time as a way to escape my
            day-to-day reality, and I fell in love. Always in search of ways to
            grow, I decided to continue my education as a Tech Elevator Java
            bootcamp student.
          </p>
        </div>
      </div>
      <div class="member three">
        <img
          src="https://media-exp1.licdn.com/dms/image/C4D03AQHS61keCmWerg/profile-displayphoto-shrink_800_800/0/1628117326198?e=1638403200&v=beta&t=l5FIIHgWQsEkRMktxX2Cfqne8I8qTDL0u5gj84uv0gQ"
        />
        <div class="text">
          <span class="full-name"
            >Tyler <span class="last-name">Vicari</span></span
          >
          <p class="member-about">
            My journey through software development began as a mere curiosity
            into a topic that someone close to me mentioned in early 2020. This
            topic unleashed an ever-expanding world of possibilities into my
            life and forever changed the way I view and interact with the
            technologies that have become an integral part of our lives and yet
            are far too easy to take for granted. Conceptualizing and working
            through the logic of designing personal applications has become a
            pleasurable part of my daily routine.
          </p>
        </div>
      </div>
      <div class="member four">
        <img
          src="https://media-exp1.licdn.com/dms/image/C4E03AQG9pPmNammr6w/profile-displayphoto-shrink_800_800/0/1633062344207?e=1638403200&v=beta&t=NY--fn64lol7NOBYz7RboaWXH8yRIUOj2gMTDJo7YNo"
        />
        <div class="text flipped">
          <span class="full-name"
            >Vellencia <span class="last-name">Knightly</span></span
          >
          <p class="member-about">
            Breaking things down just to put them back together. My childhood
            was conducted by the need to understand how things worked in pieces
            and as a whole, and this first led me to a career in accounting.
            There, I was able to develop my communication skills and my
            attention to detail, but throughout all of that time, I held a
            persistent love for computers which eventually evolved into my
            enrollment at Tech Elevator. The fast-paced curriculum tests my
            adaptability and problem-solving skills, but it hsa overall made me
            a better developer for it.
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Roboto:wght@700&display=swap");
.about-header {
  display: flex;
  justify-content: center;
  width: 100%;
  min-width: 600px;
  margin: 0 0 5% 0;
}
h2 {
  text-align: center;
  font-size: 2.5em;
  width: 50%;
  border-bottom: 2px solid #e76f51;
  border-top: 2px solid #264653;
  box-shadow: 7px 5px 0 #2a9d8f, -5px -7px 0 #f4a261;
}
.team-members {
  padding: 0 20%;
}

.member:nth-child(odd) {
  display: flex;
  flex-direction: row-reverse;
  margin: 3% 0;
  min-width: 600px;
}

.member:nth-child(even) {
  display: flex;
  min-width: 600px;
}

.member > img {
  align-self: center;
  border: 2px solid #264653;
  border-radius: 500px;
  max-height: 200px;
  margin: 4% 5%;
  box-shadow: 3px 3px 5px darkgrey;
}

.text {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 3% 5% 3% 0;
}

.text.flipped {
  padding-left: 5%;
}

.text.flipped > .full-name {
  display: flex;
  justify-content: flex-end;
}

.full-name {
  font-size: 2em;
  align-items: baseline;
  border-bottom: 2px solid #264653;
}

.last-name {
  font-family: "Bebas Neue", sans-serif;
  font-size: 1.2em;
}
.text.flipped > .full-name > .last-name {
  margin-left: 7px;
}

.member-about {
  font-size: 1.1em;
}

.member.one > .text > .full-name > .last-name {
  color: #e76f51;
}
.member.two > .text > .full-name > .last-name {
  color: #2a9d8f;
}

.member.three > .text > .full-name > .last-name {
  color: #f4a261;
}
.member.four > .text > .full-name > .last-name {
  color: #e9c46a;
}
</style>