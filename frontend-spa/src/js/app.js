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
  contentEl.innerHTML = home(albums);
  footerEl.innerHTML = footer();
  bindImages(albums);

  const addAlbumBtn = contentEl.querySelector(".addAlbumButton");
  const titleInputEl = contentEl.querySelector(".titleInput");
  const recordInputEl = contentEl.querySelector(".recordLabelInput");
  const imageInputEl = contentEl.querySelector(".imageInput");


  //function to allow for a new album to be added
  addAlbumBtn.addEventListener("click", () => {
    console.log("clicked!");
    const newAlbumJson = {
      title: titleInputEl.value,
      recordLabel: recordInputEl.value,
      image: imageInputEl.value,
      songs: [],
      comments: [],
    };
    fetch(`http://localhost:8080/albums/addAlbum`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newAlbumJson),
    })
      .then((res) => res.json())
      .then((albums) => {
        console.log(albums[albums.length - 1]);
        makeAlbumView(albums[albums.length - 1]);
      })
      .catch((error) => console.log(error));
  });
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

  const songDivs = contentEl.querySelectorAll(".songs");

  // const titleInputEl = contentEl.querySelector(".titleInput");
  // const recordInputEl = contentEl.querySelector(".recordLabelInput");
  // const imageInputEl = contentEl.querySelector(".imageInput");
  songDivs.forEach((songDiv) => {
    const idEl = songDiv.querySelector(".songID");
    const addCommentInputEl = songDiv.querySelector(".addCommentInput");
    const addCommentBtn = songDiv.querySelector(".addCommentBtn");

    const addRatingEl = songDiv.querySelector(".addRatingInput");
    const addRatingBtn = songDiv.querySelector(".addRatingBtn");

    const renameSongBtn = songDiv.querySelector(".changeSongTitleBtn");
    //event listener to add COMMENTS to SONGS
    addCommentBtn.addEventListener("click", () => {
      console.log("clicked!");
      fetch(`http://localhost:8080/songs/${idEl.value}/addSongComment`, {
        method: "PATCH",

        body: addCommentInputEl.value,
      })
        .then((res) => res.json())
        .then((newAlbum) => {
          makeAlbumView(newAlbum);
        })
        .catch((error) => console.log(error));
    });
    //listener to add RATINGS to SONGS
    // addRatingBtn.addEventListener("click", () => {
    //   fetch(`http://localhost:8080/songs/${idEl.value}/addRating`, {
    //     method: "PATCH",

    //     body: addRatingEl.value,
    //   })
    //     .then((res) => res.json())
    //     .then((newAlbum2) => {
    //       displayAlbums(newAlbum2);
    //     })
    //     .catch((error) => console.log(error));
    // });
    //enables RENAMING of SONGS
    renameSongBtn.addEventListener("click", () => {
      const renameSongEl = songDiv.querySelector(".songRename");
      fetch(`http://localhost:8080/songs/+${idEl.value}`, {
        method: "PATCH",
        body: renameSongEl.value,
      })
        .then((res) => res.json())
        .then((newAlbum3) => {
          displayAlbums(newAlbum3);
        });
    });
    //enables DELETING of SONGS
    const deleteButton = songDiv.querySelector(".deleteSong");
    deleteButton.addEventListener("click", () => {
      fetch(`http://localhost:8080/songs/${idEl.value}`, {
        method: "DELETE",
      })
        .then((res) => res.json())
        .then((newAlbum4) => {
          makeAlbumView(newAlbum4);
        });


    });


  });
  //add SONG to ALBUM
  // const songInputEl = document.querySelector(".songInput");
  // const addSongBtn = document.querySelector(".addSongButton");
  // const albumIdEl = document.querySelector(".albumID");

  // addSongBtn.addEventListener("click", () => {
  //   const newSongJSON = {
  //     "title": songInputEl.value
  //   }
  //   fetch(`http://localhost:8080/albums/${albumIdEl.value}/addSong`, {
  //     method: 'POST', 
  //     headers: {
  //       'Content-Type': 'application/json'
  //     },
  //     body: JSON.stringify(newSongJSON)
  //   })
  //   .then(res => res.json())
  //   .then(song => {
  //     makeAlbumView(song);
  //   })
  // })





}
