def call(String status) {
    slackSend(
        channel: '#ci-cd-alerts',
        color: status == 'SUCCESS' ? 'good' : 'danger',
        message: "Pipeline ${status}: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
    )
}
