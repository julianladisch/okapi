

buildMvn {
  publishModDescriptor = 'no'
  publishAPI = 'yes'
  mvnDeploy = 'yes'

  doDocker = { 
    buildJavaDocker {
      dockerDir = 'okapi-core'
      overrideConfig  = 'no'
      publishMaster = 'no'
      healthChk = 'yes'
      healthChkCmd = 'curl --fail http://localhost:9130/_/proxy/health || exit 1'
      runArgs = 'dev'
    }
  }
}

