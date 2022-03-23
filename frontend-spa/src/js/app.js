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
//   const titleEl = containerEl.querySelectorAll(".title");

//   titleEl.forEach((album) => {
//     console.log(album);
//     albums.forEach((albumJSON) => {
//       if (albumJSON.title == titleEl.value) {
//         displayAlbums(albumJSON);
//       }
//     });
//   });
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


    const albumRetitleForm = document.createElement("form");
    albumRetitleForm.classList.add("change-album-title-form");
    const albumRetitleInput = document.createElement("input");
    albumRetitleInput.classList.add("new-album-title");
    albumRetitleInput.setAttribute("type", "text");
    albumRetitleInput.setAttribute("placeholder", "Rename the album...");
    const submitRetitleAlbumButton = document.createElement("button");
    submitRetitleAlbumButton.classList.add("submit-album-retitle");
    submitRetitleAlbumButton.innerText = "Submit New Album Title";

    const singleAlbumPageEl = document.querySelector(".singleAlbumPage");
    singleAlbumPageEl.appendChild(albumRetitleForm);
    singleAlbumPageEl.appendChild(albumRetitleInput);

    // submitRetitleAlbumButton.addEventListener("click", (clickEvent) => {
    //     clickEvent.preventDefault();
    //     const retitleJson = JSON.stringify(albumRetitleInput.value);
    //     const unqoutedJson = retitleJson.replace(/\"/g, "");
    //     fetch(, {
    //         method: "PATCH",
    //         body: unqoutedJson
    //     })
    //         .then(response => response.json())
    //         .then(album => displayAlbum(album))
    //         .catch(error => console.log(error));
    // })

}
