import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";

const containerEl = document.querySelector(".container");

function displayAlbums() {
    fetch("http://localhost:8080/albums")
        .then(res => res.json())
        .then(albums => {
            displayAlbumsFromJSON(albums);
        })
}

function displayAlbumsFromJSON(albums) {

    containerEl.innerHTML = header();
    containerEl.innerHTML += home(albums);
    containerEl.innerHTML += footer();
    
    const titleEl = containerEl.querySelectorAll(".title");

    titleEl.forEach(album => {
        console.log(album);
        albums.forEach(albumJSON => {
            if (albumJSON.title == titleEl.value) {
                displayAlbums(albumJSON);
            }
        })
      
    })
    
}

displayAlbums();






