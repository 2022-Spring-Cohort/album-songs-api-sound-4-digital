
export default function home(albums) {
    return `

    <section class="albums">${albums.map(album => {
        return `<h2 class="title">${album.title}</h2>
                <h2 class="img">${album.image}</h2>
                <h2 class="songs">${album.songs}</h2>
    </section>

    
    `}).join("")}`
    
}