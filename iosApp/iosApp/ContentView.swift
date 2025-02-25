import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        ArticlesScreen(viewModel: ArticlesScreen.ArticlesViewModelWrapper())
	}
}
