
export default function home(albums) {
    return `

    <section class="albums">${albums.map(album => {
        return `<section class="indAlbums"><h1 class="title">${album.title}</h1>
                <img class="img_thumb" src="${album.image}">
                <input class="albumID" type="hidden" value="${album.id}">
                <article class="songs">${album.songs.map(song => {
                    // return `<h3 class="songTitles">${song.songTitle}`;
                }).join("")}</article></section>
    

    
    `}).join("")}</section>
    <div class="newAlbumDiv">
        <input type="text" placeholder="Album Name" class="titleInput" \>
        <input type="text" placeholder="Record Label" class="recordLabelInput" \>
        <input type="text" placeholder="Image (as text)" class="imageInput" \>
            
        <button class="addAlbumButton" ><img class="buttomImg" src="./src/img/vinyl.gif" height="100%" width="100%"></button>
        <p>^Click to add^</p>
        
    </div>
    `
    
}
