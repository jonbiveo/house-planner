<template>
    <div class="pageAlignment">
        <div class="background">
            <div class="materialTable">
                <table>
                    <tr>
                        <th></th>
                        <th>SqFt</th>
                        <th>Total</th>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>$14 - $25</td>
                        <td>$14,000 - $25,000</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                    <tr>
                        <td>Lumber</td>
                        <td>{{}}</td>
                        <td>{{}}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
</template>

<script>
export default {
    data() {
        return {
            // import the cost data from the store and use inside table
        }
    }
}
</script>

<style>
.pageAlignment {
    display: grid;
    height: 50vh;
    margin-top: 30px;
    grid-template-columns: 1fr;
    justify-items: center;
}

.background {
    display: grid;
    grid-template-columns: 1fr;
    grid-template-areas: 
    "";
    justify-items: center;
    align-items: center;
    width: 60vw;
    min-height: 550px;
    background-color: #ffe9b3;
    border-radius: 10px;
    padding: 10px;
    box-shadow: 5px 5px 5px #264653;
}

table {
    border-spacing: 10px;
}


</style>