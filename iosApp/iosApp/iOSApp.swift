import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        KoinIosInitKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

