//
//  AboutScreen.swift
//  iosApp
//
//  Created by Natiq Haciyev on 19.06.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack{
            AboutListView()
                .navigationTitle("About Device")
                
        }.padding(.horizontal, 8)
    }
}
