
export default function home(albums) {
    return `

    <section class="albums">${albums.map(album => {
        return `<section class="indAlbums"><h1 class="title">${album.title}</h1>
                <img class="img_thumb" src="${album.image}">
                <article class="songs">${album.songs.map(song => {
                    // return `<h3 class="songTitles">${song.songTitle}`;
                }).join("")}</article></section>
    

    
    `}).join("")}</section>`
    
}