import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";
import albumView from "./albumView.js";

const containerEl = document.querySelector(".container");
const contentEl = document.querySelector(".content");
const footerEl = document.querySelector(".footer");

function displayAlbums() {
  fetch("http://localhost:8080/albums")
    .then((res) => res.json())
    .then((albums) => {
      displayAlbumsFromJSON(albums);
    });
}

function displayAlbumsFromJSON(albums) {
  containerEl.innerHTML = header();
  contentEl.innerHTML= home(albums);
  footerEl.innerHTML = footer();
    bindImages(albums);

    const addAlbumBtn = contentEl.querySelector(".addAlbumButton");
    const titleInputEl = contentEl.querySelector(".titleInput");
    const recordInputEl = contentEl.querySelector(".recordLabelInput");
    const imageInputEl = contentEl.querySelector(".imageInput");
    
    addAlbumBtn.addEventListener("click", () => {
        // clickEvent.preventDefault();
        console.log("clicked!");
        const newAlbumJson = {
            "title": titleInputEl.value,
            "recordLabel": recordInputEl.value,
            "image": imageInputEl.value,
            "songs": [],
            "comments": []
        }
        fetch(`http://localhost:8080/albums/addAlbum`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newAlbumJson)
            })
            .then(res => res.json())
            .then(albums => {
                console.log(albums[albums.length-1])
                makeAlbumView(albums[albums.length-1]);
            })
            .catch(error => console.log(error));
    })
    
}


displayAlbums();


function bindImages(albumJSON) {
  const sectionEls = document.querySelectorAll(".indAlbums");
  sectionEls.forEach((sectionEl) => {
    const idEl = sectionEl.querySelector(".albumID");

    albumJSON.forEach((album) => {
      if (album.id == idEl.value) {
        sectionEl.addEventListener("click", () => {
        makeAlbumView(album);
        });
      }
    });
  });
}


function makeAlbumView(album) {
    containerEl.innerHTML = header();
    contentEl.innerHTML = albumView(album);
    footerEl.innerHTML = footer();





}
