SUMMARY = "fbcp-ili9341 application"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE.txt;md5=e07269cd84249a454c5d152cf5176dd5"

DEPENDS = "vc-graphics-libonly"
RDEPENDS:${PN} = "vc-graphics-libonly"

SRC_URI = "git://github.com/juj/fbcp-ili9341.git;branch=master \
           file://start_mirrorhdmi \
          "

SRCREV = "98e7a58ca2ea4fa316a15c3190560287a38a3eed"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DST7789VW=ON \
                 -DGPIO_TFT_DATA_COMMAND=25 \
                 -DGPIO_TFT_RESET_PIN=27 \
                 -DGPIO_TFT_BACKLIGHT=24 \
                 -DDISPLAY_WIDTH=320 \
                 -DDISPLAY_HEIGHT=240 \
                 -DDISPLAY_BREAK_ASPECT_RATIO_WHEN_SCALING=ON \
                 -DSPI_BUS_CLOCK_DIVISOR=30 \
                 -DSTATISTICS=0 \
                 -DSINGLE_CORE_BOARD=ON \
                 -DUSE_DMA_TRANSFERS=OFF"
do_install() {
    install -d ${D}${bindir}
    install -m 0766 ${B}/fbcp-ili9341 ${D}${bindir}
    install -m 0755 ${WORKDIR}/start_mirrorhdmi ${D}${bindir}
}
