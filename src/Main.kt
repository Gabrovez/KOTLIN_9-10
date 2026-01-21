fun  main (){
    val manager = ResourceManager()
    val minerals = OutpostResource(1,"Minerals",120)
    val gas = OutpostResource(2,"Gas",40)
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
}