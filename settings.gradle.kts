rootProject.name = "LogiCraft"

include("common")
include("core")
//include("inventory")
//include("lot-management")
include("master-data")
//include("purchase-order")
//include("receiving")
//include("serial-number")
//include("shipping")

rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
}