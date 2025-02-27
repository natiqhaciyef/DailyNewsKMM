//
//  ArticleScreen.swift
//  iosApp
//
//  Created by Natiq Haciyev on 24.02.25.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import shared
    
    @MainActor
    class ArticleViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticleViewModel
        
        init() {
            articlesViewModel = ProvideViewModel().getArticleViewModel()
            articlesState = articlesViewModel.articleState.value
        }
        
        @Published var articlesState: ArticleUIState
        
        func startObserving() {
            Task {
                for await articlesS in articlesViewModel.articleState {
                    await MainActor.run {
                        self.articlesState = articlesS
                    }
                }
            }
        }

    }

struct ArticlesScreen: View {
    @ObservedObject private(set) var viewModel: ArticleViewModelWrapper
    
    var body: some View {
        VStack{
            AppBar()
            
            if viewModel.articlesState.isLoading {
                Loader()
            }
            
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            
            if(!viewModel.articlesState.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articlesState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
            
        }.onAppear{
            self.viewModel.startObserving()
        }
    }
}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct ArticleItemView: View {
    var article: ArticleModel
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            Text(article.desc)
            Text(article.date).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}
