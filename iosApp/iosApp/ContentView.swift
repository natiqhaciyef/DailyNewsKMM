import SwiftUI
import shared


struct ContentView: View {
//    @State private var shouldOpenAbout = false
    
    var body: some View {
        let articleScreen = ArticlesScreen(viewModel: .init())
        NavigationStack{
            articleScreen
                .toolbar {
                    ToolbarItem {
                        Button {
//                            shouldOpenAbout.toggle()
                        } label: {
                            Label(
                                "About", systemImage:"info.circle"
                            ).labelStyle(.titleAndIcon)
                        }
//                        .popover(isPresented: $shouldOpenAbout) {
//                            AboutScreen()
//                        }
                    }
                }
        }.refreshable {
            articleScreen.viewModel.articlesViewModel.getArticles(isRefresh: true)
        }
    }
}
