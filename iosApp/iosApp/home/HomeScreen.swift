import SwiftUI
import shared

struct HomeScreen: View {
    @State private var titleSize: CGFloat = 20
    @StateObject var viewModel = HomeViewModel()
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
    
	var body: some View {
        NavigationStack {
                ScrollView {
                    LazyVGrid(columns: gridColumns, spacing: 16) {
                        ForEach(viewModel.movies, id: \.id) { movie in
                            NavigationLink(value: movie) {
                                MovieItem(movie: movie)
                                    .task {
                                        if movie == viewModel.movies.last && !viewModel.loadFinished && !viewModel.isLoading {
                                            await viewModel.loadMovies()
                                        }
                                    }
                            }.buttonStyle(PlainButtonStyle())
                        }
                        
                    }.padding(.horizontal, 16)
                        .navigationDestination(for: Movie.self) { movie in
                            DetailScreen(movie: movie)
                        }
                    
                }
                .navigationTitle("Movies")
                .foregroundColor(.white)
                .navigationBarTitleDisplayMode(.inline)
                .toolbarColorScheme(.dark, for: .navigationBar)
                .toolbarBackground(.visible, for: .navigationBar)
                .background(Color("colorMidnightExpress"))
            
        }
        .task { await viewModel.loadMovies() }
	}
}

struct HomeScreen_Previews: PreviewProvider {
	static var previews: some View {
		HomeScreen()
	}
}
