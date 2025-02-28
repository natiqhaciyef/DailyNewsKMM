import SwiftUI
import shared


struct ContentView: View {
////    @State private var shouldOpenAbout = false
//    
    var body: some View {
        NavigationStack{
            ArticlesScreen(viewModel: .init())
//                .toolbar {
//                    ToolbarItem {
//                        Button {
////                            shouldOpenAbout.toggle()
//                        } label: {
//                            Label(
//                                "About", systemImage:"info.circle"
//                            ).labelStyle(.titleAndIcon)
//                        }
////                        .popover(isPresented: $shouldOpenAbout) {
////                            AboutScreen()
////                        }
//                    }
//                }
        }
    }
}
