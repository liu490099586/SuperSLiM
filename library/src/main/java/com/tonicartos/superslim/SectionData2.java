package com.tonicartos.superslim;

import android.view.View;

public class SectionData2 {

    public final int firstPosition;

    public final boolean hasHeader;

    final int marginStart;

    final int marginEnd;

    public final int minimumHeight;

    public final int sectionManager;

    public final int headerWidth;

    public final int headerHeight;

    public final int contentEnd;

    public final int contentStart;

    LayoutManager.LayoutParams headerParams;

    public SectionData2(LayoutManager lm, View first) {
        final int paddingStart = lm.getPaddingStart();
        final int paddingEnd = lm.getPaddingEnd();

        headerParams = (LayoutManager.LayoutParams) first.getLayoutParams();

        if (headerParams.isHeader) {
            headerWidth = lm.getDecoratedMeasuredWidth(first);
            headerHeight = lm.getDecoratedMeasuredHeight(first);

            if (headerParams.headerStartMarginIsAuto) {
                if (headerParams.isHeaderStartAligned() && !headerParams.isHeaderOverlay()) {
                    marginStart = headerWidth;
                } else {
                    marginStart = 0;
                }
            } else {
                marginStart = headerParams.headerMarginStart;
            }
            if (headerParams.headerEndMarginIsAuto) {
                if (headerParams.isHeaderEndAligned() && !headerParams.isHeaderOverlay()) {
                    marginEnd = headerWidth;
                } else {
                    marginEnd = 0;
                }
            } else {
                marginEnd = headerParams.headerMarginEnd;
            }
        } else {
            headerHeight = 0;
            headerWidth = 0;
            marginStart = headerParams.headerMarginStart;
            marginEnd = headerParams.headerMarginEnd;
        }

        contentEnd = marginEnd + paddingEnd;
        contentStart = marginStart + paddingStart;

        hasHeader = headerParams.isHeader;

        minimumHeight = hasHeader ? headerHeight : 0;

        firstPosition = headerParams.getTestedFirstPosition();

        sectionManager = headerParams.sectionManager;
    }

    public int getTotalMarginWidth() {
        return marginEnd + marginStart;
    }
}
