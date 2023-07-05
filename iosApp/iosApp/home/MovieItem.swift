import SwiftUI
import shared

struct MovieItem: View {
    @State private var isLoadingImage: Bool = false
    let movie: Movie
   
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            ZStack {
                AsyncImage(url: URL(string: movie.imageUrl)) { image in
                    ZStack {
                        image.resizable()
                        Circle()
                            .frame(width: 56, height: 56)
                            .foregroundColor(.black.opacity(0.6))

                        Image(systemName: "play.fill")
                            .foregroundColor(.white)
                    }
                } placeholder: {
                    ZStack {
                        Color.gray.opacity(0.8)
                        ProgressView("Loading...")
                            .progressViewStyle(CircularProgressViewStyle(tint: .white))
                            .foregroundColor(.white)
                    }
                }
            }.frame(maxWidth: .infinity, idealHeight: .infinity)
             .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(movie.title)
                .font(.title3)
                .fontWeight(.bold)
                .lineLimit(1)
            
            Text(movie.releaseDate)
                .font(.caption)
            
        }.frame(maxWidth: .infinity, maxHeight: 260)
    }
}
