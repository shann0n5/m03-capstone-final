<template>
  <header class="app-header">
    <img class="logo" src="../src/assets/Screenshot 2023-12-03 143827 (1).png"> 
     <h1>Real-TE Management</h1> 
  </header>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'aboutUs'}">About Us</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'availableProperties'}">See Rentals</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'qualifications'}">Apply Here</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'contactUs'}">Contact Us</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    
    </div>
    <router-view />
  </div>
  <footer>
    copy right and credentials here
  </footer>
</template>


<style>

body {
        margin: 0;
    }

    /* Add CSS Grid here  background colors: Header - #f69a00;  Nav - #f2ead2;  
    main - #f9f5f0;  aside - #f2ead2;  footer - #331312;
    font colors header, footer - #ffffff;  nav, main, aside - #74889a;*/

    .container{
        display: grid;

        grid-template-areas: 
            "header header header" 
            "nav content side"
            "footer footer footer";

        grid-template-columns: 200px 1fr 200px;
        grid-template-rows: 125px 1fr 85px;
        gap: 10px;

        height: 100vh;


    }
    /*handle responsive behavior */
    @media (max-width: 768px) {
        .container{
            grid-template-areas: 
                "header"
                "nav"
                "content"
                "side"
                "footer";
            grid-template-columns: 1fr;
            grid-template-rows:
                auto /*Header */
                75px /*Nav*/
                1fr /* content */
                75px /* Sidebar */
                auto; /* Footer */
            
        }
        header, footer, nav, main, aside {
            padding: 5px 0;
        }
        nav, aside {
        margin: 0;
        }

    }

    

    .logo {
      border-radius: 50%;
      height: 10rem;
      padding: 10px;
    }

    header {
    grid-area: header;
    background-color: #6f828e;
    display: flex;
    }

    nav {
        grid-area: nav;        
        background-color: #f2ead2;
    }

    main {
        grid-area: content;
        background-color: #f9f5f0;
    }

    aside {
        grid-area: side;        
        background-color: #f2ead2;
    }

    footer {
        grid-area: footer;
        background-color: #41565a;
    }

    header, footer {
        color: #ffffff;
    }
    nav, main, aside {
        color: #74889a;
    }
    header, footer, nav, main, aside {
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 24px;
        text-transform: uppercase;
    }

    div.content {
        text-align: center;
        padding-top: 20px;
    }
</style>
