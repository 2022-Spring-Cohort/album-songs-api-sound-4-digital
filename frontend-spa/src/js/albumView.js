
export default function albumView(album) {
    return `<section class="singleAlbumPage">
    <h2 class="single_title">${album.title}</h2>
    <img class="img_thumb" src="${album.image}">
    <h4 class="recordLabel">${album.recordLabel}</h4>
    <input class="albumID" type="hidden" value="${album.id}">

    <section class="song-list">${album.songs.map(song => {
        return `<div class="songs">${song.songTitle}</div>
        <div class="duration">${song.duration}</div>
        <div class="rating">Rating: ${song.songRatings}</div>
        <div class="comments">${song.comments}</div>
        <button class="deleteSong">Delete</button>


        
        
        `
    })}
    </section>
    <button class="deleteAlbum">Delete Album</button>`
    
}




