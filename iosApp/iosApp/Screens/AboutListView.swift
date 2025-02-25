//
//  AboutListView.swift
//  iosApp
//
//  Created by Natiq Haciyev on 25.02.25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared
import SwiftUI

struct AboutListView: View {
    private struct RowItem: Hashable{
        let title: String
        let details: String
    }
    
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()
        
        var result: [RowItem] = [
            .init(
                title: "Operating System : ",
                details: "\(platform.osName) \(platform.osVersion)"
            ),
            .init(
                title: "Device : ",
                details: "\(platform.deviceModel)"
            ),
            .init(
                title: "Density : ",
                details: "@\(platform.density)x"
            )
        ]
        
        return result
    }()
    
    
    var body: some View {
        List {
            ForEach(items, id: \.self){ item in
                HStack(alignment: .center){
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.details)
                        .font(.footnote)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}
