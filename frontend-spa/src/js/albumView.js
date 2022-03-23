
export default function albumView(album) {
    return `<section class="singleAlbumPage">
    <h2 class="single_title">${album.title}</h2>
    <img class="img_thumb" src="${album.image}">
    <input class="albumID" type="hidden" value="${album.id}">

    <section class="song-list">${album.songs.map(song => {
        return `<div class="songs">${song.songTitle}</div>
        <div class="duration">${song.duration}</div>
        <div class="comments">${song.comments}</div>


        <div class="rating">${song.averageRating}</div>
        
        `
    })}
    </section>`
    
}




