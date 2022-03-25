
export default function albumView(album) {
    return `<section class="singleAlbumPage">
    <button class="backBtn">BACK</button>
    <h1 class="single_title">${album.title}</h1>
    <h3 class="albumRating">Rating: ${album.albumRating}</h3>
    <input type="number" placeholder="Add rating here" class="addAlbumRating"/>
    <button class="addAlbumRatingBtn">Add Rating</button>
    <h4 class="recordLabel">Label: ${album.recordLabel}</h4>
    <input class="albumID" type="hidden" value="${album.id}">
    <img class="img_thumb" src="${album.image}">
    <h4 class="albumComments">${album.comments}</h4>

    <input type="text" placeholder="Add comment here" class="addAlbumComment"/>
    <button class="addAlbumCommentBtn">Add Comment</button>


    <section class="song-list">${album.songs.map(song => {
        return `<div class="songs"><h3>${song.songTitle}</h3>
        <div class="duration">Duration: ${song.duration}</div>
        <div class="rating">Rating: ${song.songRatings}</div>
        <div class="comments">${song.comments}</div>
        <input class="songID" type="hidden" value="${song.id}">



        <input type="text" placeholder="Add comment here" class="addCommentInput" />
        <button class="addCommentBtn">Add Comment</button>
        <br>
        <input type="number" placeholder="Add rating here" class="addRatingInput" />
        <button class="addRatingBtn">Add Rating</button>
        <br>
        <input type="text" placeholder="Change Song Title" class="songRename" />
        <button class="changeSongTitleBtn">Change Song Title</button>

        
        <br>
        <button class="deleteSong">Delete Song</button>

        
        </div>
        `
    })}
    </section>
    <br>
    <br>
    <input type="text" placeholder="New Song" class="songInput" \>
    <button class="addSongButton">Add Song</button>
    
    <br>
    <input type="text" placeholder="Change Album Title" class="albumRename" />
    <button class="updateAlbumTitle">Change Album Name</button>
    <br>
    <button class="deleteAlbumBtn">Delete Album</button>
    <br>
    <br>`
}






