
export default function songs(album) {
    return `
    <section class="song-list">${album.map(song => {
        return `<div class="songs">${song.songTitle}</div>
        
        `
    })}
    `
}
