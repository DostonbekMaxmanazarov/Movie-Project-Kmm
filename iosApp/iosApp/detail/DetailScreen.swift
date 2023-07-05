import SwiftUI
import shared

struct DetailScreen: View {
    
    let movie: Movie
    
    var body: some View {
        ScrollView {
            VStack {
                ZStack {
                    AsyncImage(url:URL(string: movie.imageUrl)) { image in
                        image.resizable().scaledToFill()
                    } placeholder: {
                        ProgressView()
                    }
                }.frame(maxWidth: .infinity, maxHeight: 300)
                
                VStack(alignment: .leading, spacing: 16) {
                    Text(movie.title)
                        .font(.title)
                        .fontWeight(.bold)
                        .fixedSize(horizontal: false, vertical: true)
                        .foregroundColor(.white)
                    
                    Button(action: {}) {
                        HStack {
                            Image(systemName: "play.fill")
                                .foregroundColor(.white)
                            
                            Text("Start watching now")
                                .foregroundColor(.white)
                        }
                    }.frame(maxWidth: .infinity, maxHeight: 56)
                        .padding()
                        .background(Color("colorTurquoiseBlue"))
                        .clipShape(RoundedRectangle(cornerRadius: 8))
                    
                    Text("Released in \(movie.releaseDate)".uppercased())
                        .font(.caption)
                        .foregroundColor(.white)
                    
                    Text(movie.description_)
                        .font(.body)
                        .fixedSize(horizontal: false, vertical: true)
                        .foregroundColor(.white)
                }.padding(20)
                
            }.frame(maxWidth: .infinity, maxHeight: .infinity)
            
        }.background(Color("colorMidnightExpress"))
    }
}
