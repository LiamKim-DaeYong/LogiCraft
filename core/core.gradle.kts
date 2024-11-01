description = "LogiCraft Core Module"

dependencies {
    implementation(project(":master-data"))
    implementation(project(":inbound"))
    implementation(project(":outbound"))
    implementation(project(":inventory"))
    implementation(project(":lot-management"))
    implementation(project(":serial-number"))
    implementation(project(":purchase-order"))
}
